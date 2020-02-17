# ELEC574_Assignment1

I certify that all solutions are entirely in my words and I have credited all sources in this submission. - Xu Chen

This assignment is graded by Boning Li.

Note about this repo: A1 is the shake detector and pedometer project. To run the shake detector, please set the threshold to 20. For pedometer please enter the thresholds from 4 to 6, depending on your walking habits. GestureDetect is the bonus project.

Assignment info:

I finished building up two applications: (1) the shake detector/pedometer and (2) the bonus project - the human finger gesture detector.

(1) The most challenging part for building this app was how to remove "false alarms", such as a person's hand trembles while holding the phone, which usually were wrongly detected as shakes. I've tried different methods to resolve this problem. For instance, I've tried to smooth the signals, changing the accelerometer's magnitude threshold (used for determining shakes/no shakes). They were helpful but false positives still occurred, e.g., a single actual shake led to 3-4 counts. After I talked to TAs and Prof. Sano, I realized that I should set up another threshold - the time threshold to suppress false shakes. Specfically, consider the situation where one shake followed by another, and the first shake is detected already. With our time threshold, the second shake will be counted only if it comes after this threshold; otherwise, the shake number won't change. This addtional thresholding worked well and fixed the "false alarms" problem.

(2) The most challenging part for building the bonus app "the human finger gesture detector" is to differentiate onTouchEvent and GestureDetector. In principle, the gesture detection process is two-stage: (a) gather all touch events; (b) determine gestures from the detected touch event sequences. Even if the GestureDetector.OnGestureListener actually integrates these  subprocesses, we still need to put an addtional method onTouchEvent to delegate touch events to the GestureDetector. Otherwise, the app might encounter error e.g., stopped working, etc.

