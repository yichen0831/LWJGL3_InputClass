import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWKeyCallback;

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
