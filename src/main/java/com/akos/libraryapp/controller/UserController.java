package com.akos.libraryapp.controller;

import com.akos.libraryapp.domain.dto.UserDTO;
import com.akos.libraryapp.domain.dto.VoteDTO;
import com.akos.libraryapp.domain.entity.BookOrder;
import com.akos.libraryapp.domain.entity.Vote;
import com.akos.libraryapp.domain.entity.security.User;
import com.akos.libraryapp.repositories.UserRepository;
import com.akos.libraryapp.repositories.VoteRepository;
import com.akos.libraryapp.security.AuthenticationException;
import com.akos.libraryapp.security.JwtTokenUtil;
import com.akos.libraryapp.security.JwtUser;
import com.akos.libraryapp.services.BookOrderService;
import com.akos.libraryapp.services.UserCreationException;
import com.akos.libraryapp.services.UserService;
import com.akos.libraryapp.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private VoteService voteService;


    @Autowired
    private UserService userService;

    @Autowired
    private BookOrderService bookOrderService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        return user;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDTO> getAllUsers() {
        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserDTO createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.PUT)
    public UserDTO updateUser(@PathVariable String username, @RequestBody User user) {
        return userService.updateUser(username, user);
    }

    @RequestMapping(value = "/current/vote", method = RequestMethod.POST)
    public Vote saveUserVote(@RequestBody Vote vote, HttpServletRequest request) {

        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        if (username.equals(vote.getUsername()))
            return voteService.save(vote);
        else
            throw new AuthenticationException("The username does not match the current user");
    }

    @RequestMapping(value = "/order/{bookId}", method = RequestMethod.POST)
    public BookOrder placeOrder(@PathVariable Long bookId, HttpServletRequest request) {

        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

       return bookOrderService.placeOrder(username, bookId);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable String username) {
        return userService.getUser(username);
    }

    @RequestMapping(value = "/user/{username}/votes", method = RequestMethod.GET)
    public List<VoteDTO> getUserVotes(@PathVariable String username) {

        List<VoteDTO> votes = new ArrayList<>();

        for (Vote vote : voteService.getUserVotes(username)) {
            votes.add(new VoteDTO(vote));
        }

        return votes;
    }

    @RequestMapping("/vote/{username}/{bookId}")
    public Vote getUserVotes(@PathVariable String username, @PathVariable Long bookId) {

        return voteService.getByUsernameAndBookId(username, bookId);
    }


    @RequestMapping(value = "/user/{username}/status", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public UserDTO disableUser(@PathVariable String username, @RequestParam(value = "setEnabled") Boolean setEnabled) {
        if (setEnabled) {
            return userService.enableUser(username);
        } else {
            return userService.disableUser(username);
        }
    }

    @ExceptionHandler({UserCreationException.class})
    public ResponseEntity<String> handleUserCreationException(UserCreationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleAuthException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleOtherException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getClass() + ": " + e.getMessage());
    }

}
