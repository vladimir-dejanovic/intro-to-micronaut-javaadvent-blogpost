package xyz.itshark.blog.javaadvent.intromicro.config;

import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class SimpleAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        if(authenticationRequest.getIdentity().equals("user") && authenticationRequest.getSecret().equals("password")) {
            return Flowable.just(new UserDetails("user",new ArrayList()));
        } else return Flowable.just(new AuthenticationFailed());
    }
}
