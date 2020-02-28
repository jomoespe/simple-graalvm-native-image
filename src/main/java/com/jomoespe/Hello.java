package com.jomoespe;

import java.util.function.Supplier;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public final class Hello {
    public static void main(final String... args) throws ParseException {
        CommandLine cmd = commandLine(Hello::options, () -> args);
        System.out.printf("Hello %s!\n", cmd.getOptionValue("name", "world"));
    }

    private static CommandLine commandLine(final Supplier<Options> options, final Supplier<String[]> args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        return parser.parse(options.get(), args.get());
    }

    private static Options options() {
        return new Options()
            .addOption("n", "name", true, "the name to be salutated");
    }
}
