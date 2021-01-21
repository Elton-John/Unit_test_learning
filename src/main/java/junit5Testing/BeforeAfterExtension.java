package junit5Testing;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BeforeAfterExtension implements BeforeEachCallback, AfterEachCallback {


    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("Before each extension");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("After each extension");
    }
}
