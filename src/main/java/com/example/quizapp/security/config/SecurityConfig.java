package com.example.quizapp.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.cors(cors -> cors.configurationSource(corsConfigurationSource()))
				//	HTTPリクエストに対するセキュリティ設定
				.authorizeHttpRequests(authz -> authz
						//	「/login」へのアクセスは認証を必要としない
						.requestMatchers("/", "/login", "/challenge/**", "/result", "/css/**", "/js/**", "/images/**").permitAll()
						//						【管理者権限設定】以下のurlは管理者しかアクセスできない
						.requestMatchers("/list", "/pickUp/**", "/form", "/save", "/edit/**", "/reedit",
								"/check", "/update/**", "pickUpDeleteQuestion/**", "/delete/**", "/bloglist", 
								"/editUrl/**", "/addUrl", "addYearForm", "/addYear")
						.hasAuthority("ADMIN")
						//	その他のリクエストは認証が必要
						.anyRequest().authenticated())

				//	フォームベースのログイン設定
				.formLogin(form -> form
						//	カスタムログインページのURLを指定
						.loginPage("/login") // 自作ログイン画面のURL
						//	ログイン処理のURLを指定
						.loginProcessingUrl("/authentication")
						//	ユーザ名のname属性を指定
						.usernameParameter("usernameInput")
						//	パスワードのname属性を指定
						.passwordParameter("passwordInput")
						//	ログイン成功時のリダイレクト先を指定
						.defaultSuccessUrl("/")
						//	ログイン失敗時のリダイレクト先を指定
						.failureUrl("/login?error"))

				//		ログアウト設定
				.logout(logout -> logout
						//	ログアウトを処理するURLを指定
						.logoutUrl("/logout")
						//	ログアウト成功時のリダイレクト先を指定
						.logoutSuccessUrl("/?logout")
						//	ログアウト時にセッションを無効にする
						.invalidateHttpSession(true)
						//	ログアウト時にCookieを削除する
						.deleteCookies("JSESSIONID"))

				//		セッション管理
				.sessionManagement(session -> session
						.invalidSessionUrl("/?timeout") // セッション切れ時の遷移先
						.maximumSessions(1)) // 同時ログイン数制限
		;

		return http.build();

	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOrigin("*"); // すべてのオリジンを許可
		configuration.addAllowedMethod("*"); // すべてのメソッドを許可
		configuration.addAllowedHeader("*"); // すべてのヘッダーを許可
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	
}
