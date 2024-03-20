/*package com.registerpatient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/login").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")
                    .defaultSuccessUrl("/dashboard")
                    .permitAll()
            );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
*/

// Following is the previous code for SecurityConfig.java file


 
package com.registerpatient.config;
 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails adminUser = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("admin").build();
		UserDetails doctorUser = User.withUsername("doctor").password(passwordEncoder().encode("doctor")).roles("doctor").build();
		UserDetails employeeUser = User.withUsername("employee").password(passwordEncoder().encode("employee")).roles("employee").build();
		UserDetails reportsUser = User.withUsername("reports").password(passwordEncoder().encode("reports")).roles("reports").build();

		return new InMemoryUserDetailsManager(adminUser, doctorUser, employeeUser, reportsUser);
		
		
		//return new CustomUserDetails();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests()
                .requestMatchers(updatePatientRequestMatcher()).hasAnyRole("doctor","admin")
                
                .requestMatchers("/", "/about", "/registerPatient", "/showPatients/**", "/patient/**").permitAll()
                .requestMatchers("/**").hasRole("admin")
                .requestMatchers("/updatePatient/{patientId}").hasRole("doctor")
                .anyRequest().authenticated()
                .and().formLogin(withDefaults());
		return httpSecurity.build();
	}
	
	private RequestMatcher updatePatientRequestMatcher() {
        return new AntPathRequestMatcher("/updatePatient/{patientId}");
    }

}

