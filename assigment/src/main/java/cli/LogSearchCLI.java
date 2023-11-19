package cli;

import picocli.CommandLine;

@CommandLine.Command(name = "logsearch", mixinStandardHelpOptions = true)
public class LogSearchCLI implements Runnable {

    @CommandLine.Option(names = {"-l", "--level"}, description = "Filter by log level")
    private String level;

    @CommandLine.Option(names = {"-m", "--message"}, description = "Filter by log message")
    private String message;

    @CommandLine.Option(names = {"-r", "--resourceId"}, description = "Filter by resource ID")
    private String resourceId;

    @CommandLine.Option(names = {"-t", "--timestamp"}, description = "Filter by timestamp")
    private String timestamp;

    @CommandLine.Option(names = {"--traceId"}, description = "Filter by trace ID")
    private String traceId;

    @CommandLine.Option(names = {"--spanId"}, description = "Filter by span ID")
    private String spanId;

    @CommandLine.Option(names = {"--commit"}, description = "Filter by commit")
    private String commit;

    @CommandLine.Option(names = {"--parentResourceId"}, description = "Filter by parent resource ID")
    private String parentResourceId;

    @Override
    public void run() {
        System.out.println("Searching logs...");
        System.out.println("Level: " + level);
        System.out.println("Message: " + message);
        System.out.println("Resource ID: " + resourceId);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Trace ID: " + traceId);
        System.out.println("Span ID: " + spanId);
        System.out.println("Commit: " + commit);
        System.out.println("Parent Resource ID: " + parentResourceId);
    }

    public static void main(String[] args) {
        new CommandLine(new LogSearchCLI()).execute(args);
    }
}

