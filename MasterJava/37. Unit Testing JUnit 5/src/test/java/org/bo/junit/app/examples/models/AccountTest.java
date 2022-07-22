package org.bo.junit.app.examples.models;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.bo.junit.app.examples.exception.InsufficientCashException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountTest {

    Account account;
    private TestInfo info;
    private TestReporter reporter;

    @BeforeEach
        // It is executed before each test
    void initTestMethod(TestInfo info, TestReporter reporter) {
        this.account = new Account("Andres", new BigDecimal("1000.123"));
        this.info = info;
        this.reporter = reporter;
        System.out.println("Initializing test method");
        reporter.publishEntry("Executing: " + info.getDisplayName() + ",  " + info.getTestMethod().get().getName() + ", "
                + info.getTestClass().get().getName());
    }

    @AfterEach
        // It is executed after each test
    void tearDown() {
        System.out.println("Finalizing test method");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Initializing test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizing test");
    }

    //    For unit test another convention is to use the "_", such test_account_name
    @Test
    @DisplayName("Testing account name😪")
    void testAccountName() {
        System.out.println(info.getTags().contains("account") ? "Yes, I am" : "No, I'm not");
//        account.setPerson("Andres");
        String expected = "Andres";
        String result = account.getPerson();
//        assertEquals(expected, result, "The account can't be null");
//        It's much better, it doesn't use unnecessary memory
        assertEquals(expected, result, () -> "The account can't be null");
//        assertTrue(result.equals(expected));
    }

    @Test
    @DisplayName("Testing account balance")
    void testAccountBalance() {
        assertNotNull(account.getBalance());
        assertEquals(1000.123, account.getBalance().doubleValue());
        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0, "The balance can't be negative");
        assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testAccountReference() {
        Account account1 = new Account("Jon Doe", new BigDecimal("200.10"));
        Account account2 = new Account("Jon Doe", new BigDecimal("200.10"));

//        assertNotEquals(account1, account2);
        assertEquals(account1, account2);
    }

    @Test
    void testAccountDebit() {
        account.debit(new BigDecimal("100"));
        assertNotNull(account.getBalance());
        assertEquals(900, account.getBalance().intValue());
        assertEquals("900.123", account.getBalance().toPlainString());
    }

    @Test
    void testAccountCredit() {
        account.credit(new BigDecimal("100"));
        assertNotNull(account.getBalance());
        assertEquals(1100, account.getBalance().intValue());
        assertEquals("1100.123", account.getBalance().toPlainString());
    }

    @Test
    void testAccountInsufficientCash() {
        Exception exception = assertThrows(InsufficientCashException.class, () -> {
            account.debit(new BigDecimal("5000"));
        });

        String result = exception.getMessage();
        String expected = "Insufficient cash";
        assertEquals(expected, result);
    }

    @Test
    void testTransferCashBetweenAccounts() {
        Account account1 = new Account("Jon Doe", new BigDecimal("2500"));
        Account account2 = new Account("Andres", new BigDecimal("1500.8989"));

        Bank bank = new Bank();
        bank.setName("State Bank");
        bank.transfer(account2, account1, new BigDecimal("500"));

        assertEquals("1000.8989", account2.getBalance().toPlainString());
        assertEquals("3000", account1.getBalance().toPlainString());
    }

    @Test
    void testRelationBetweenBanksAndAccounts() {
        Account account1 = new Account("Jon Doe", new BigDecimal("2500"));
        Account account2 = new Account("Andres", new BigDecimal("1500.8989"));

        Bank bank = new Bank();
        bank.setName("State Bank");
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.transfer(account2, account1, new BigDecimal("500"));

        assertEquals("1000.8989", account2.getBalance().toPlainString());
        assertEquals("3000", account1.getBalance().toPlainString());
        assertEquals(2, bank.getAccounts().size());
        assertEquals(bank.getName(), account1.getBank().getName());

        String expected = "Jon Doe";
        assertTrue(bank.getAccounts().stream()
                .anyMatch(account -> account.getPerson().equals(expected)));
        assertEquals(expected, bank.getAccounts().stream()
                .filter(account -> account.getPerson().equals(expected))
                .findFirst()
                .get().getPerson());
    }

    @Test
//    @Disabled // This show a report and the reason why it is disabled
    @DisplayName("Relation Between Banks and Accounts Assert All")
    void testRelationBetweenBanksAndAccountsAssertAll() {
//        We force the error
//        fail();
        Account account1 = new Account("Jon Doe", new BigDecimal("2500"));
        Account account2 = new Account("Andres", new BigDecimal("1500.8989"));

        Bank bank = new Bank();
        bank.setName("State Bank");
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.transfer(account2, account1, new BigDecimal("500"));

        assertAll(() -> assertEquals("1000.8989", account2.getBalance().toPlainString()),
                () -> {
                    assertEquals("3000", account1.getBalance().toPlainString());
                }, () -> {
                    assertEquals(2, bank.getAccounts().size());
                }, () -> {
                    assertEquals(bank.getName(), account1.getBank().getName());
                }, () -> {
                    String expected = "Jon Doe";
                    assertTrue(bank.getAccounts().stream()
                            .anyMatch(account -> account.getPerson().equals(expected)));
                }, () -> {
                    String expected = "Jon Doe";
                    assertEquals(expected, bank.getAccounts().stream()
                            .filter(account -> account.getPerson().equals(expected))
                            .findFirst()
                            .get().getPerson());
                });
    }

    //    Enable if the operative system is Windows
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testWindowsOnly() {

    }

    //    Enable if the operative system is Linux or Mac
    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testLinuxAndMacOnly() {

    }

    //    Disabled if the operative system is Linux
    @Test
    @DisabledOnOs(OS.LINUX)
    void testNotInLinux() {
    }

    //    Only the test case will run in Java 8
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testOnlyJava8() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testOnlyJava17() {
    }

    @Test
    @DisabledOnJre(JRE.JAVA_17)
    void testNotInJava17() {
    }

    @Test
    void printSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    @EnabledIfSystemProperty(named = "java.version", matches = "17.*")
    void testJavaVersion() {
    }

    @Test
    @DisabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void testOnlyArch64() {
    }

    @Test
    @EnabledIfSystemProperty(named = "user.name", matches = "santihs")
    void testUserName() {
    }

    @Test
    @EnabledIfSystemProperty(named = "ENV", matches = "dev")
    void testDev() {
    }

    @Test
    void printEnvironmentVariables() {
        Map<String, String> getenv = System.getenv();
        getenv.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = "/usr/lib/jvm/java-17-oracle/")
    void testJavaHome() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "SNAP_VERSION", matches = ".*202.*")
    void testProcessor() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "dev")
    void testEnv() {
    }

    //    Assumptions
    @Test
    @DisplayName("Testing account balance DEV")
    void testAccountBalanceDev() {
        boolean isDev = "dev".equals(System.getProperty("ENV"));
        assumeTrue(isDev); // Verify a boolean to continue executing the tests
        assertNotNull(account.getBalance());
        assertEquals(1000.123, account.getBalance().doubleValue());
        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0, "The balance can't be negative");
        assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("Testing account balance 2")
    void testAccountBalanceDevTwo() {
        boolean isDev = "dev".equals(System.getProperty("ENV"));
        assumingThat(isDev, () -> {
            assertNotNull(account.getBalance());
            assertEquals(1000.123, account.getBalance().doubleValue());
        }); // Verify a boolean to continue executing the tests
        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0, "The balance can't be negative");
        assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    //    Repeated Test
    @RepeatedTest(value = 5, name = "Number {currentRepetition} of {totalRepetitions} repetitions")
    @DisplayName("Account Debit Repetition Test")
    void testAccountDebitRepeated(RepetitionInfo info) {
        if (info.getCurrentRepetition() == 3) {
            System.out.println("I'm the " + info.getCurrentRepetition());
        }
        account.debit(new BigDecimal("100"));
        assertNotNull(account.getBalance());
        assertEquals(900, account.getBalance().intValue());
        assertEquals("900.123", account.getBalance().toPlainString());
    }

    //    Parameterized Test
    @Nested
    @Tag("Param")
    class ParamTest {
        @ParameterizedTest(name = "{index} : {argumentsWithNames}")
        @DisplayName("Account Debit PT Strings")
        @ValueSource(strings = {"100", "200", "500", "700", "1000"})
        void testAccountDebitParameterizedTest(String amount) {
            account.debit(new BigDecimal(amount));
            assertNotNull(account.getBalance());
            assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "{index} : {argumentsWithNames}")
        @ValueSource(ints = {100, 200, 500, 700, 1000})
        @DisplayName("Account Debit PT Integers")
        void testAccountDebitParameterizedTestTwo(int amount) {
            account.debit(new BigDecimal(amount));
            assertNotNull(account.getBalance());
            assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "{index} : {argumentsWithNames}")
        @DisplayName("Account Debit PT CSV")
        @CsvSource({"1, 100", "2, 200", "3, 500", "4, 700", "5, 1000"})
        void testAccountDebitParameterizedCSVTest(String index, String amount) {
            System.out.println(index + "->" + amount);
            account.debit(new BigDecimal(amount));
            assertNotNull(account.getBalance());
            assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "{index} : {argumentsWithNames}")
        @DisplayName("Account Debit PT CSV File")
        @CsvFileSource(resources = "/data.csv")
        void testAccountDebitParameterizedCSVFileTest(String amount) {
            account.debit(new BigDecimal(amount));
            assertNotNull(account.getBalance());
            assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "{index} : {argumentsWithNames}")
        @DisplayName("Account Debit PT CSV 2")
        @CsvSource({"200, 100, Andres, Andres", "250, 200, Pepe, Pepe", "501, 500, Maria, Maria",
                "750, 700, Marc, Marc", "1002, 1000, Lucas, Lucas"})
        void testAccountDebitParameterizedCSVTwoTest(String balance, String amount, String expected, String result) {
            System.out.println(balance + "->" + amount);

            account.setPerson(result);
            account.setBalance(new BigDecimal(balance));
            account.debit(new BigDecimal(amount));

            assertNotNull(account.getPerson());
            assertNotNull(account.getBalance());
            assertEquals(expected, account.getPerson());
            assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "{index} : {argumentsWithNames}")
        @DisplayName("Account Debit PT CSV File 2")
        @CsvFileSource(resources = "/data2.csv")
        void testAccountDebitParameterizedCSVFileTwoTest(String balance, String amount, String expected, String result) {
            account.debit(new BigDecimal(amount));
            account.setPerson(result);

            assertNotNull(account.getBalance());
            assertNotNull(account.getBalance());
            assertEquals(expected, account.getPerson());
            assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
        }
    }

    @Tag("Param")
    @ParameterizedTest(name = "{index} : {argumentsWithNames}")
    @DisplayName("Account Debit PT Method")
    @MethodSource("listAmount")
    void testAccountDebitParameterizedMethodTest(String amount) {
        account.debit(new BigDecimal(amount));
        assertNotNull(account.getBalance());
        assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    private static List<String> listAmount() {
        return Arrays.asList("100", "200", "500", "700", "1000");
    }

    //    Timeout
    @Nested
    @Tag("timeout")
    class ExampleTimeOutTest {
        @Test
        @Timeout(1)
        void testTimeOut() throws InterruptedException {
//            TimeUnit.SECONDS.sleep(2);
            TimeUnit.MILLISECONDS.sleep(998);
        }

        @Test
        @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
        void testTimeOutTwo() throws InterruptedException {
//            TimeUnit.SECONDS.sleep(2);
            TimeUnit.MILLISECONDS.sleep(200);
        }

        @Test
        void testAssertTimeOut() {
            assertTimeout(Duration.ofSeconds(5), () -> {
                TimeUnit.SECONDS.sleep(2);
            });
        }
    }

}