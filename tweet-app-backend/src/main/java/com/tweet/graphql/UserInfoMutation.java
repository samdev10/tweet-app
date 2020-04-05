package com.tweet.graphql;

import static com.tweet.bo.UserInfo.SEQUENCE_NAME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tweet.bo.UserInfo;
import com.tweet.repository.UserInfoRepository;
import com.tweet.utill.SequenceGeneratorService;

import graphql.kickstart.tools.GraphQLMutationResolver;

/**
 * User Info Mutation.
 */
@Component
public class UserInfoMutation implements GraphQLMutationResolver {
    @Autowired
    private transient UserInfoRepository userRepo;
    private transient PasswordEncoder passwordEncoder;
    @Autowired
    private transient SequenceGeneratorService sequenceGenerator;

    /**
     * @param userInfo the userInfo
     * @return a userInfo
     */
    public UserInfo saveUserInfo(final UserInfo userInfo) {
        final Long sequenceNumber = sequenceGenerator.generateSequence(SEQUENCE_NAME);
        passwordEncoder = new BCryptPasswordEncoder();
        userInfo.setId(sequenceNumber);
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return userRepo.save(userInfo);
    }

}
