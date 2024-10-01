package order;

import member.Grade;
import member.Member;

public class PercentDiscountPolicyImpl implements DiscountPolicy {

	// 할인 퍼센트: 10%
	private double discountPercent = 10.0;
	
	@Override
	public int discount(Member member, int price) {
		// VIP 회원만 할인 금액 적용
		if(member.getGrade() == Grade.VIP) {
			return (int)(price * (discountPercent / 100)); // 10% 할인된 금액
		}
		return 0;
	}
}
