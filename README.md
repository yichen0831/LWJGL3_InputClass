# LWJGL3_InputClass
A input class for use in LWJGL3 which help easier handle the KeyCallback

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
