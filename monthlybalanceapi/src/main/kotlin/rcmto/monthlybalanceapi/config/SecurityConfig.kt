package rcmto.monthlybalanceapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import rcmto.monthlybalanceapi.jwt.JwtConfigure
import rcmto.monthlybalanceapi.jwt.JwtTokenProvider

@Configuration
class SecurityConfig(jwtTokenProvider: JwtTokenProvider) : WebSecurityConfigurerAdapter() {
    private val jwtTokenProvider: JwtTokenProvider = jwtTokenProvider

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Throws(Exception::class)
    protected override fun configure(http: HttpSecurity) {
        http.httpBasic().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .anyRequest().permitAll()
//            .anyRequest().authenticated() -> usar para bloquear acesso
            .and()
            .apply(JwtConfigure(jwtTokenProvider))
    }

}