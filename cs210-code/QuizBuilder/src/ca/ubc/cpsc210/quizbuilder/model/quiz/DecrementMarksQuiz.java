package ca.ubc.cpsc210.quizbuilder.model.quiz;

import ca.ubc.cpsc210.quizbuilder.model.exceptions.OutOfTriesException;
import ca.ubc.cpsc210.quizbuilder.model.exceptions.RetryAnswerException;
import ca.ubc.cpsc210.quizbuilder.model.question.Question;
import ca.ubc.cpsc210.quizbuilder.model.questionslist.QuestionsList;

/**
 * Created by HardingLiu on 2015-07-23.
 */
public class DecrementMarksQuiz extends EachAnswerMustBeRightQuiz {
    public DecrementMarksQuiz(QuestionsList questions) {
        super(questions);
    }

    @Override
    public String submitAnswer(String answer) throws RetryAnswerException, OutOfTriesException {
        boolean correct = super.checkAnswer(answer);

        if ((!correct) && (super.curQuestion.getMaxMark() > 1)) {
            super.curQuestion.setMaxMark(super.curQuestion.getMaxMark() - 1);
            throw new RetryAnswerException("Wrong answer, please retry.");
        } else if ((!correct) && (super.curQuestion.getMaxMark() <= 1)) {
            throw new OutOfTriesException("You already have used all of the tries.");
        }
        return "";
    }

}
