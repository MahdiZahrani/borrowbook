package ir.mzahrani.service.Impl;

import ir.mzahrani.dto.LoginRequestDTO;
import ir.mzahrani.dto.LoginResponseDTO;
import ir.mzahrani.entity.Token;
import ir.mzahrani.entity.User;
import ir.mzahrani.repository.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl {

    private final UserServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getUsername(),
                        loginRequestDTO.getPassword())
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);
        saveToke(token, userDetails);
        return new LoginResponseDTO(token);
    }

    private void saveToke(String token, UserDetails userDetails) {
        Token saveToken = Token.builder()
                .token(token)
                .expired(Boolean.FALSE)
                .revoked(Boolean.FALSE)
                .user((User) userDetails)
                .build();

        tokenRepository.save(saveToken);

    }

    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
