Programming Assignment: Image Classifier

Names: Jamie and Stanley

/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours: 1.5 hours


/**********************************************************************
 * Part 1. Some people (especially in Europe and Latin America) write *
 * a 7 with a line through the middle, while others (especially in    *
 * Japan and Korea) make the top line crooked.                        *
 *                                                                    */

/**********************************************************************
 * a. Suppose that the training data consists solely of samples that  *
 * do not use any of these conventions. How well do you think the      *
 * algorithm will perform when you test it on different populations?  *
 * What are the possible consequences?                                *
 **********************************************************************/

ANSWER: The algorithim would most likely misclassify those following samples due to its inexperience
with those conventions of writing. As a result we can expect a higher error rate for those samples. 

/**********************************************************************
 * b. Now suppose that you are using a supervised learning algorithm  *
 * to diagnose cancer. Suppose the training data consists of examples *
 * solely on individuals from population X but you use it on          *
 * individuals from population Y. What are the possible consequences? *
 **********************************************************************/

ANSWER: It may be possible that the learning algorithim may misclassify individuals from population Y, however because the
target is diagnosing cancer, they may be less negative consequences for testing on a different population. 

/**********************************************************************
 * Part 2
 * 1. What digit is misclassified the most frequently?                *
 * 2. For this digit,  what are the top two digit that your           *
 *    MultiPerceptron incorrectly predicts?                           *
 * 3. Examine some of these misclassified images. Provide an explana- *
 *    tion what might have caused these misclassifications.           *
 **********************************************************************/
ANSWER:

1. Most frequently misclassified digit: 9

2. Top two digits misclassified are: 8

3. Explanation:

    The nines in the testing files have a lot of variation between them depending on how they are drawn. Eights also have appear differently
    in terms of size of the loops. 

/**********************************************************************
 * Did you receive help from classmates, past students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

No. 




/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Machine Learning




/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/

Time for part II, perceptron boogaloo!
