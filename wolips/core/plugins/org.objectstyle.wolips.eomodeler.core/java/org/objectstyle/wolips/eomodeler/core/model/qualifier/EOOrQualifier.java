package org.objectstyle.wolips.eomodeler.core.model.qualifier;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class EOOrQualifier extends EOAggregateQualifier {
	private List<EOQualifier> _qualifiers;

	public EOOrQualifier() {
		_qualifiers = new LinkedList<EOQualifier>();
	}

	public EOOrQualifier(Collection<EOQualifier> qualifiers) {
		_qualifiers = new LinkedList<EOQualifier>();
		for (EOQualifier qualifier : qualifiers) {
			if (qualifier instanceof EOOrQualifier) {
				_qualifiers.addAll(((EOOrQualifier) qualifier).getQualifiers());
			} else {
				_qualifiers.add(qualifier);
			}
		}
	}

	public EOOrQualifier(EOQualifier... qualifiers) {
		_qualifiers = new LinkedList<EOQualifier>();
		for (EOQualifier qualifier : qualifiers) {
			if (qualifier instanceof EOOrQualifier) {
				_qualifiers.addAll(((EOOrQualifier) qualifier).getQualifiers());
			} else {
				_qualifiers.add(qualifier);
			}
		}
	}

	public List<EOQualifier> getQualifiers() {
		return _qualifiers;
	}

	public String toString(int depth) {
		StringBuffer sb = new StringBuffer();
		if (depth > 0) {
			sb.append("(");
		}
		for (int i = 0; i < _qualifiers.size(); i ++) {
			if (i > 0) {
				sb.append(" or ");
			}
			sb.append(_qualifiers.get(i).toString(depth + 1));
		}
		if (depth > 0) {
			sb.append(")");
		}
		return sb.toString();
	}
}
