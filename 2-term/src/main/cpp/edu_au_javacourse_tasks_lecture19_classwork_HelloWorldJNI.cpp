#include "edu_au_javacourse_tasks_lecture19_classwork_HelloWorldJNI.h"
#include <iostream>

JNIEXPORT void JNICALL Java_edu_au_javacourse_tasks_lecture19_classwork_HelloWorldJNI_sayHello (JNIEnv* env, jclass thisClass) {
  std::string hello = "Hello from C++ !!";
  std::cout << hello << std::endl;
}
