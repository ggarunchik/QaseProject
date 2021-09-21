package configurations;

import lombok.extern.log4j.Log4j2;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Log4j2
public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (retryCount < MAX_RETRY) {
                retryCount++;
                result.setStatus(ITestResult.FAILURE);
                log.info("Retrying once again. \n" +
                        "Current retry number is: " + retryCount + ".\n " +
                        "Remaining attempts: " + (MAX_RETRY - retryCount));
                return true;
            } else {
                result.setStatus(ITestResult.FAILURE);
            }
        } else {
            result.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
