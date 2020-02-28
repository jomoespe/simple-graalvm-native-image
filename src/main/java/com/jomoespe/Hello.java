package com.jomoespe;

import java.util.Optional;
import java.util.function.Supplier;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public final class Hello {
    public static void main(final String... args) {
        final Optional<CommandLine> cmd = commandLine(Hello::options, () -> args);
        System.out.printf("Hello %s!\n", name(cmd));
    }

    private static String name(final Optional<CommandLine> cmd) {
        final String defaultName = "world";
        return cmd.isPresent() ? cmd.get().getOptionValue("name", defaultName) : defaultName;
    }

    private static Optional<CommandLine> commandLine(final Supplier<Options> options, final Supplier<String[]> args) {
        try {
            CommandLineParser parser = new DefaultParser();
            return Optional.of(parser.parse(options.get(), args.get()));
        } catch (ParseException e) {
            System.err.printf("Error parsing command line arguments: %s\n", e.getMessage());
            e.printStackTrace(System.err);
            return Optional.empty();
        }
    }

    private static Options options() {
        final Options options = new Options()
            .addOption("n", "name", true, "the name to say hello");
        return options;
    }
}
