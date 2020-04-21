package chapter06.item36;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class NewTextClient {

	public void printStyle() {
		NewText newText = new NewText();

		// EnumSet 사용
		EnumSet<NewText.Style> styles = EnumSet.of(NewText.Style.BOLD, NewText.Style.ITALIC);
		newText.applyStyles(styles);

		// 불변으로 만들기 위해 Collections.unmodifiableSet()으로 감싸기
		Set<NewText.Style> unmodifiableStyles = Collections.unmodifiableSet(EnumSet.of(NewText.Style.BOLD, NewText.Style.ITALIC));
		newText.applyStyles(unmodifiableStyles);
	}
}
