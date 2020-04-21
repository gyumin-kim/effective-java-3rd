package chapter06.item36;

import static chapter06.item36.OldText.STYLE_BOLD;
import static chapter06.item36.OldText.STYLE_ITALIC;

public class OldTextClient {

	public void printStyle() {
		OldText oldText = new OldText();
		oldText.applyStyles(STYLE_BOLD | STYLE_ITALIC);
	}
}
