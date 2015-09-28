# LWJGL3_InputClass
A input class for use in LWJGL3 which help easier handle the KeyCallback.

This input class only accepts one checker. That is, the key state is reset to idle after being checked. Thus, the key input will only be used one time. For example, if several objects call Input.isKeyPressed(GLFW_KEY_SPACE), only the first object who accesses the call will get true, others will get false.

If you would like to have the key input being checked for several time during one update loop, you can refer to [LWJGL3_InputClass2](https://github.com/yichen0831/LWJGL3_InputClass2).

##Usage:

1. import the InputClass.
```
    import where.you.put.the.class.Input;
```

2. set it to the GLFWKeyCallback
```
    glfwSetKeyCallback(window, keyCallback = new Input());
```

3. Easily check anytime anywhere the input by
```
    // when key is down (including first pressed and repeated)
    if(Input.isKeyDown(GLFW_KEY_SPACE)) {
        System.out.println("space down");
    }

    // only when key is first pressed
    if(Input.isKeyPressed(GLFW_KEY_SPACE)) {
        System.out.println("space pressed");
    }

    // only when key is repeated
    if(Input.isKeyRepeated(GLFW_KEY_SPACE)) {
        System.out.println("space repeated");
    }

    // when the key is released
    if(Input.isKeyReleased(GLFW_KEY_SPACE)) {
        System.out.println("space released");
    }
```
