# ELEC574_Assignment1

I certify that all solutions are entirely in my words and I have credited all sources in this submission. - Xu Chen

This assignment is graded by Boning Li.

Note about this repo: A1 is the shake detector and pedometer project. To run the shake detector, please set the threshold to 20. For pedometer please enter the thresholds from 4 to 6, depending on your walking habits. GestureDetect is the bonus project.

Assignment info:

I finish building up two applications: (1) the shake detector/pedometer and (2) the bonus project - the human finger gesture detector.

(1) The most challenging part for building this app was how to remove "false alarms", such as a person's hand trembles while holding the phone, which usually were wrongly detected as shakes. I've tried different methods to resolve this problem. For instance, I've tried to smooth the signals, changing the accelerometer's magnitude threshold (used for detecting shakes/no shakes) but in vain. After I talked to TAs and Prof. Sano, I realized that I needed to set up another threshold
