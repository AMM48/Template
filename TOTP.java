package edu.kau.fcit.cpit252.utils;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;
import java.time.Duration;
import java.time.Instant;

public class TOTP {
    // Generates a TOTP with a password length of 8 digits, time step (10 minutes), and HMAC algorithm (HMAC-SHA1).
    public static String generateTOTP(int timeToLiveMillis) throws NoSuchAlgorithmException, InvalidKeyException {
        Duration timeStep = Duration.ofMinutes(timeToLiveMillis);
        final TimeBasedOneTimePasswordGenerator totp = new TimeBasedOneTimePasswordGenerator(timeStep);
        final KeyGenerator keyGenerator = KeyGenerator.getInstance(totp.getAlgorithm());
        final int macLengthInBytes = Mac.getInstance(totp.getAlgorithm()).getMacLength();
        keyGenerator.init(macLengthInBytes * 8);
        final Key key = keyGenerator.generateKey();
        final Instant now = Instant.now();
        return totp.generateOneTimePasswordString(key, now);
    }
}
