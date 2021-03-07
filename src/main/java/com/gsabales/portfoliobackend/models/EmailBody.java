package com.gsabales.portfoliobackend.models;

/**
 * Created by Glenn Sabales on 2/17/2021
 */
public abstract class EmailBody {

    public String name() { return "All"; }

    public final String greeting() { return "Hello " + name() + "!<br><br>"; }

    public abstract String content();

    public String footer() {
        return "<i>This is sent as a feedback from my portfolio website</i><br/><br/>\n" +
               "<b>~End of Message.~</b>`";
    }

    public String getBody() {
        return greeting() + content() + footer();
    }

}
