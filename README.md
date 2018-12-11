# -Entity-Recognize-
哈工大命名实体识别系统
命名识别系统在EntityRecognize文件夹中，使用jdk32版本，IDE是eclipse

EntityRecognize\src\com\crfpp 这个包为CRF命名实体识别程序

EntityRecognize\src\com\test 为main方法所在处，执行Test程序会生成最后的实体识别文件，
但是由于格式不符合评测程序的要求，所以需要执行EntityRecognize\src\com\crfpp 下的AnswerFormatter程序

EntityRecognize\src\com\leftBoundaryFeature为特征文件生成程序，在执行Test程序时会先执行此程序
data文件夹下为所有的实验文本文件
