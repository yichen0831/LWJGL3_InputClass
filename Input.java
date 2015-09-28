import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWKeyCallback;

/* [LWJGL3_InputClass](https://github.com/yichen0831/LWJGL3_InputClass)
 *
 * A input class for use in LWJGL3 which help easier handle the KeyCallback.
 *
 * This input class only accepts one checker. That is, the key state is reset to
 * idle after being checked. Thus, the key input will only be used one time.
 *
 * For example, if several objects call Input.isKeyPressed(GLFW_KEY_SPACE),
 * only the first object who accesses the call will get true, others will get false.
 *
 * If you would like to have the key input being checked for several time
 * during one update loop, you can refer to
 * [LWJGL3_InputClass2](https://github.com/yichen0831/LWJGL3_InputClass2).
 *
*/

public class Input extends GLFWKeyCallback {
	public enum KeyState {
		Idle,
		Release,
		Press,
		Repeat,
	};

	public static KeyState[] keyState = new KeyState[GLFW_KEY_LAST];

	private static void clearKeyState(int key) {
		keyState[key] = KeyState.Idle;
	}

	public static boolean isKeyDown(int key) {
		if(keyState[key] == KeyState.Press || keyState[key] == KeyState.Repeat) {
			clearKeyState(key);
			return true;
		}
		return false;
	}

	public static boolean isKeyPressed(int key) {
		if(keyState[key] == KeyState.Press) {
			clearKeyState(key);
			return true;
		}
		return false;
	}

	public static boolean isKeyRepeated(int key) {
		if(keyState[key] == KeyState.Repeat) {
			clearKeyState(key);
			return true;
		}
		return false;
	}

	public static boolean isKeyReleased(int key) {
		if(keyState[key] == KeyState.Release) {
			clearKeyState(key);
			return true;
		}
		return false;
	}

	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		switch(action) {
		case GLFW_RELEASE:
			keyState[key] = KeyState.Release;
			break;
		case GLFW_PRESS:
			keyState[key] = KeyState.Press;
			break;
		case GLFW_REPEAT:
			keyState[key] = KeyState.Repeat;
		}
	}
}
