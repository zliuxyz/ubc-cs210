package ca.ubc.cpsc210.quizbuilder.model.question;

import java.io.PrintStream;

/**
 * Created by HardingLiu on 2015-07-22.
 */
public class MultiplicationQuestion extends Question {
    protected int factor1;
    protected int factor2;

    public MultiplicationQuestion(double maxMark, int factor1, int factor2) {
        super(maxMark, factor1 + " * " + factor2 + " = ???");
        this.factor1 = factor1;
        this.factor2 = factor2;
    }


    @Override
    public boolean isCorrect(String answer) {

        try {
            int Answer = Integer.parseInt(answer);
            if (Answer == factor1 * factor2) {
            return true;
        }
            else
            return false;

        }

        catch (NumberFormatException e) {
            return false;
        }

    }
}
