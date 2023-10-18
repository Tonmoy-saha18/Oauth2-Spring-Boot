# Getting Started

### Reference Documentation
* In this application we are using github as our authorization server. In my code base I have done this using java configuration but we can configure this in other way also which I have discussed below.
* For using github as our authorization server we need client_id and client_secret of a github app. Create a github from here https://github.com/settings/applications/new. You will get ``client id`` and `client secret` after creating an github app. Then you need to use that client id and secret for configuring github as our authorization server.

### Alternatives
* Instead of making a configuration like I did in security config. We can also declare client id and secret ``application.yaml`` or ``application.properties`` file.
* The properties file should look like this: 
```agsl
spring.security.oauth2.client.registration.github.client-id=ghdsbyr7yr2676y43987
spring.security.oauth2.client.registration.github.client-secret=gcshdfcdshvhvnfdh87t8hgu8967fd
```
* Here in this case when the application will start it will create all the bean that we have created by our configuration code. In that case our configuration file should look like this int the below:
```agsl
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.oauth2Login();
        httpSecurity.authorizeHttpRequests()
                .anyRequest()
                .authenticated();
        return httpSecurity.build();
    }
}
```
