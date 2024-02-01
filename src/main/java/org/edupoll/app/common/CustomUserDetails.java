package org.edupoll.app.common;

import java.util.Collection;
import java.util.Set;

import org.edupoll.app.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

	
	private Account account;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (account.getGrade() == 1) {
			return Set.of(new SimpleGrantedAuthority("BEGINNER"));
		} else if (account.getGrade() == 2) {
			return Set.of(new SimpleGrantedAuthority("BEGINNER"), new SimpleGrantedAuthority("EXPERT"));
		} else {
			return Set.of(new SimpleGrantedAuthority("BEGINNER"), new SimpleGrantedAuthority("EXPERT"),
					new SimpleGrantedAuthority("MASTER"));
		}
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	

}
