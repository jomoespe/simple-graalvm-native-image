package com.jomoespe;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Hello {
    public static void main(String... args) throws ParseException {
        Options options = new Options();

        Option nameOpt = new Option("n", "name", true, "input file path");
        nameOpt.setRequired(false);
        options.addOption(nameOpt);

        CommandLineParser parser = new DefaultParser();
        //HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = parser.parse(options, args);

        String name = cmd.getOptionValue("name", "world");
        System.out.printf("Hello %s!!\n", name);
    }
}