package com.letscodemom.cli;

import com.beust.jcommander.Parameter;
/**
 * This class is used to parse the command line arguments
 * The @Parameter annotation is used to specify the command line arguments
 * The names attribute is used to specify the short and long form of the command line arguments
 * The description attribute is used to specify the description of the command line arguments
 * The help attribute is used to specify that the command line argument
 * The required attribute is used to specify that the command line argument is required
 */

public class CLIArguments {
    CLIArguments() {
    }
    @Parameter(
            required = true,
            descriptionKey = "keyword",
           // validateValueWith = CLIKeywordValidator.class
            description = "The keyword to search for"
    )
    private String keyword;
    @Parameter(
            names = {"--location", "-l"},
            description = "The location to search for"
    )
    private String location;
    @Parameter(
            names = {"--page", "-p"},
            description = "The page number"
    )
    private int page = 0;
    @Parameter(
            names = {"--full-time", "-f"},
            description = "The job type"
    )
    private boolean isFullTime = false;
    @Parameter(
            names = {"--help", "-h"},
            help = true,
            //validateValueWith = CLIHelpValidator.class,
            description = "Prints the usage"
    )
    private boolean isHelp;

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CLIArguments newInstance() {
        return new CLIArguments();
    }
}
