package org.edupoll.app.common;

import java.util.Optional;

import org.edupoll.app.entity.Account;
import org.edupoll.app.repository.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.RequiredArgsConstructor;

// @Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> optional = accountRepository.findById(username);
//		if(optional.isEmpty()) {
//			throw new UsernameNotFoundException(username +" is not exist.");
//		}
//		Account account = optional.get();

		Account account = optional.orElseThrow(() -> {
			return new UsernameNotFoundException(username + " is not exist.");
		});
		return CustomUserDetails.builder().account(account).build();
//		return new CustomUserDetails(account);
	}

}
