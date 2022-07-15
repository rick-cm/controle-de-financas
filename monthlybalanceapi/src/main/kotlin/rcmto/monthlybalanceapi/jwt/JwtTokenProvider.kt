package rcmto.monthlybalanceapi.jwt

import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import javax.servlet.http.HttpServletRequest

@Service
class JwtTokenProvider {
    @Value("\${security.jwt.token.secret-key}")
    private var secretKey: String? = null

    fun getAuthentication(token: String?): Authentication {
        val userDetails: UserDetails = object : UserDetails {
            override fun getAuthorities(): Collection<GrantedAuthority?> {
                return Collections.emptyList()
            }
            override fun getPassword(): String { return ""}
            override fun getUsername(): String { return getUsername(token) }
            override fun isAccountNonExpired(): Boolean { return true }
            override fun isAccountNonLocked(): Boolean { return true }
            override fun isCredentialsNonExpired(): Boolean { return true }
            override fun isEnabled(): Boolean { return true }
        }
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    fun resolveToken(req: HttpServletRequest): String? {
        val bearerToken = req.getHeader("Authorization")
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7, bearerToken.length);
        } else null
    }

    fun validateToken(token: String?): Boolean {
        return try {
            val body = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .body
            val expirationDate: Date = body.expiration
            val data = expirationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
            return !LocalDateTime.now().isAfter(data)
        } catch (e: JwtException) {
            false
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    fun getUsername(token: String?): String {
        return Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(token)
            .body.subject
    }
}