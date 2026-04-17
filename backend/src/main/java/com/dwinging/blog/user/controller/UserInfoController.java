package com.dwinging.blog.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dwinging.blog.user.dto.request.SignInDTO;
import com.dwinging.blog.user.dto.request.SignUpDTO;
import com.dwinging.blog.user.dto.request.UpdateRequestDTO;
import com.dwinging.blog.user.dto.response.UserInfo;
import com.dwinging.blog.user.service.UserInfoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user_info")
@RequiredArgsConstructor
public class UserInfoController {
	
	private final UserInfoService userInfoService;
	
	@PostMapping("/sign-in")
	public ResponseEntity<UserInfo> signIn(@RequestBody SignInDTO dto) {
		return ResponseEntity.ok(userInfoService.signIn(dto));
	}
	
	@PostMapping("/sign-out")
	public ResponseEntity<Void> signOut(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
        
        if (session != null) {
            session.invalidate();
        }
        
        return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/signUp")
	public ResponseEntity<Long> createInfo(@RequestBody SignUpDTO dto) {
		return ResponseEntity.status(201).body(userInfoService.signUp(dto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Long> updateInfo(
			@PathVariable Long id,
			@RequestBody UpdateRequestDTO dto) {
		return ResponseEntity.ok(userInfoService.updateInfo(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInfo(@PathVariable Long id) {
		userInfoService.deleteAccount(id);
		return ResponseEntity.noContent().build();
	}
}
