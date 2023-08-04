package web.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class RetryTestExtension implements TestWatcher {

    private int maxRetries = 3; // Максимальное количество попыток перезапуска

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        if (getRetryCount(context) < maxRetries) {
            context.publishReportEntry("Retry", "Retrying test: " + context.getDisplayName());
            context.getExecutionException().ifPresent(cause::addSuppressed);
            context.getTestMethod().ifPresent(method -> {
                context.getTestInstance().ifPresent(testInstance -> {
                    try {
                        method.invoke(testInstance); // Перезапуск упавшего теста
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            });
        }
    }

    private int getRetryCount(ExtensionContext context) {
        return context.getStore(ExtensionContext.Namespace.create(getClass(), context.getRequiredTestMethod()))
                .getOrComputeIfAbsent("retryCount", key -> 0, Integer.class);
    }


}
