package classesprof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProgressTokensProf {

	public static final List<ProgressTokenProf> TOKENS = Collections.unmodifiableList(createTokenList());
	
	// there is 1 token of each type, and 2 tokens of the same 'Culture' type
	private static List<ProgressTokenProf> createTokenList() {
		List<ProgressTokenProf> res = new ArrayList<ProgressTokenProf>();
		res.addAll(Arrays.asList(ProgressTokenProf.values()));
		res.add(ProgressTokenProf.Culture);
		return res;
	}

}
