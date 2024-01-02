package concurrency.book.threadSafety;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigDecimal;
import java.math.BigInteger;

//Stateless Objects are always thread-safe
public class StatelessFactorizer {
    public void service(ServletRequest req, ServletResponse resp){
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        encodeIntoResponse(resp, factors);
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return BigInteger.valueOf(1);
    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[]{BigInteger.ONE, BigInteger.ONE};
    }
}
