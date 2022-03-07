Programming Assignment: Perceptron

Names: Stanley and Jamie
/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours: 1.5 hours


/**********************************************************************
 * List your instance variables and the comments you had for each:    *
 **********************************************************************/

For Perceptron:
private int n; // n inputs
private double[] weights; //array with n inputs

For MultiPerceptron:
private int m,n; // m classes, n inputs
private Perceptron[] perceptrons; //array with m perceptrons, each perceptron initialized with n inputs

/**********************************************************************
 * Analysis:                                                          *
 * 1. What digit is misclassified the most frequently?                *
 * 2. For this digit,  what are the top two digit that your           *
 *    MultiPerceptron incorrectly predicts?                           *
 * 3. Examine some of these misclassified images. Provide an explana- *
 *    tion what might have caused these misclassifications.           *
 **********************************************************************/

1. Most frequently misclassified digit: 1

2. Top two digits misclassified are: 1,2

3. Explanation: 

The ones were written at different angles, and some even had a notch on top, making it look like a 7.

The twos had many different variations, some having a curly bump, while others just had a straight line.


/**********************************************************************
 *  Did you receive help from classmates, past students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

no

/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

no

/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/



