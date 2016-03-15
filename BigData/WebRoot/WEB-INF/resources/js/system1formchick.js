// JavaScript Document
function agelowchick(){
	 agelow=frm.minAge.value;
	    if(agelow.length <1){
			divagelow.innerHTML='<font class="tips_false">请输入</font>';
			}
        else if(agelow > 10 && agelow < 100)  
        {  	
            divagelow.innerHTML='<font class="tips_false"></font>';
             
        }
		else if(agelow > 100)  
        {  	
            divagelow.innerHTML='<font class="tips_false">必须小于100</font>';
             
        }else{  
            divagelow.innerHTML='<font class="tips_true">必须大于10</font>';
           
	}
}
function clearagelow(){
	divagelow.innerHTML='<font class="tips_true"></font>';
	}	
	
function agehighchick(){
	 agelow=frm.minAge.value;
	 agehigh=frm.maxAge.value;
	    if(agehigh.length <1){
			divagehigh.innerHTML='<font class="tips_false">请输入</font>';
			}
        else if(agehigh < agelow)  
        {  	
            divagehigh.innerHTML='<font class="tips_false">应该大于最小</font>';
             
        }
		else if(agehigh > agelow && agehigh < 100){  	
            divagehigh.innerHTML='<font class="tips_true"></font>';
             
        }
		else{
			 divagehigh.innerHTML='<font class="tips_true">必须小于100</font>';
			}
}
function clearagehigh(){
	divagehigh.innerHTML='<font class="tips_true"></font>';
	}	
	
	
	
	
	
	
//月收入验证	
function minMonthlyIncomechick(){
	 agelow=frm.minMonthlyIncome.value;
	    if(agelow.length <1){
			divminMonthlyIncome.innerHTML='<font class="tips_false">请输入</font>';
			}
        else if(agelow > 1 && agelow < 100000)  
        {  	
           divminMonthlyIncome.innerHTML='<font class="tips_false"></font>';
             
        }
		else if(agelow > 100000)  
        {  	
           divminMonthlyIncome.innerHTML='<font class="tips_false">必须小于100000</font>';
             
        }else{  
           divminMonthlyIncome.innerHTML='<font class="tips_true">必须大于1</font>';
           
	}
}
function minMonthlyIncomeclear(){
	divminMonthlyIncome.innerHTML='<font class="tips_true"></font>';
	}	
	
function maxMounthlyIncomechick(){
	 agelow=frm.minMonthlyIncome.value;
	 agehigh=frm.maxMounthlyIncome.value;
	    if(agehigh.length <1){
			divmaxMounthlyIncome.innerHTML='<font class="tips_false">请输入</font>';
			}
        else if(agehigh < agelow)  
        {  	
            divmaxMounthlyIncome.innerHTML='<font class="tips_false">应该大于最小</font>';
             
        }
		else if(agehigh > agelow && agehigh < 100000){  	
            divmaxMounthlyIncome.innerHTML='<font class="tips_true"></font>';
             
        }
		else{
			divmaxMounthlyIncome.innerHTML='<font class="tips_true">必须小于100000</font>';
			}
}
function maxMounthlyIncomeclear(){
	divmaxMounthlyIncome.innerHTML='<font class="tips_true"></font>';
	}	
	
	
	
//信用卡账户数验证	
function minCreditNumchick(){
	 agelow=frm.minCreditNum.value;
	    if(agelow.length <1){
			divminCreditNum.innerHTML='<font class="tips_false">请输入</font>';
			}
        else if(agelow > 1 && agelow < 10)  
        {  	
           divminCreditNum.innerHTML='<font class="tips_false"></font>';
             
        }
		else if(agelow > 10)  
        {  	
           divminCreditNum.innerHTML='<font class="tips_false">必须小于10</font>';
             
        }else{  
           divminCreditNum.innerHTML='<font class="tips_true">必须大于1</font>';
           
	}
}
function minCreditNumclear(){
	divminCreditNum.innerHTML='<font class="tips_true"></font>';
	}	
	
	
function maxCreditNumchick(){
	 agelow=frm.minCreditNum.value;
	 agehigh=frm.maxCreditNum.value;
	    if(agehigh.length <1){
			divmaxCreditNum.innerHTML='<font class="tips_false">请输入</font>';
			}
        else if(agehigh < agelow)  
        {  	
            divmaxCreditNum.innerHTML='<font class="tips_false">应该大于最小</font>';
             
        }
		else if(agehigh > agelow && agehigh < 10){  	
            divmaxCreditNum.innerHTML='<font class="tips_true"></font>';
             
        }
		else{
			divmaxCreditNum.innerHTML='<font class="tips_true">必须小于10</font>';
			}
}
function maxCreditNumclear(){
	divmaxCreditNum.innerHTML='<font class="tips_true"></font>';
	}	
	
	
//住房贷款数验证	
function minHouseLoanchick(){
	 agelow=frm.minHouseLoan.value;
	    if(agelow.length <1){
			divminHouseLoan.innerHTML='<font class="tips_false">请输入</font>';
			}
        else if(agelow > 1 && agelow < 10)  
        {  	
           divminHouseLoan.innerHTML='<font class="tips_false"></font>';
             
        }
		else if(agelow > 10)  
        {  	
           divminHouseLoan.innerHTML='<font class="tips_false">必须小于10</font>';
             
        }else{  
           divminHouseLoan.innerHTML='<font class="tips_true">必须大于1</font>';
           
	}
}
function minHouseLoanclear(){
	divminHouseLoan.innerHTML='<font class="tips_true"></font>';
	}	
	
	
function maxHouseLoanchick(){
	 agelow=frm.minHouseLoan.value;
	 agehigh=frm.maxHouseLoan.value;
	    if(agehigh.length <1){
			divmaxHouseLoan.innerHTML='<font class="tips_false">请输入</font>';
			}
        else if(agehigh < agelow)  
        {  	
            divmaxHouseLoan.innerHTML='<font class="tips_false">应该大于最小</font>';
             
        }
		else if(agehigh > agelow && agehigh < 10){  	
            divmaxHouseLoan.innerHTML='<font class="tips_true"></font>';
             
        }
		else{
			divmaxHouseLoan.innerHTML='<font class="tips_true">必须小于10</font>';
			}
}
function maxHouseLoanclear(){
	divmaxHouseLoan.innerHTML='<font class="tips_true"></font>';
	}
	
	
//其他款数验证	
function minLoansNumchick(){
	 agelow=frm.minLoansNum.value;
	    if(agelow.length <1){
			divminLoansNum.innerHTML='<font class="tips_false">请输入</font>';
			}
        else if(agelow > 1 && agelow < 10)  
        {  	
           divminLoansNum.innerHTML='<font class="tips_false"></font>';
             
        }
		else if(agelow > 10)  
        {  	
           divminLoansNum.innerHTML='<font class="tips_false">必须小于10</font>';
             
        }else{  
           divminLoansNum.innerHTML='<font class="tips_true">必须大于1</font>';
           
	}
}
function minLoansNumclear(){
	divminLoansNum.innerHTML='<font class="tips_true"></font>';
	}	
	
	
function maxLoansNumchick(){
	 agelow=frm.minLoansNum.value;
	 agehigh=frm.maxLoansNum.value;
	    if(agehigh.length <1){
			divmaxLoansNum.innerHTML='<font class="tips_false">请输入</font>';
			}
        else if(agehigh < agelow)  
        {  	
            divmaxLoansNum.innerHTML='<font class="tips_false">应该大于最小</font>';
             
        }
		else if(agehigh > agelow && agehigh < 10){  	
            divmaxLoansNum.innerHTML='<font class="tips_true"></font>';
             
        }
		else{
			divmaxLoansNum.innerHTML='<font class="tips_true">必须小于10</font>';
			}
}
function maxLoansNumclear(){
	divmaxLoansNum.innerHTML='<font class="tips_true"></font>';
	}
	
//总数验证
function generateRecordNumchick(){
	 totalvalue=frm.generateRecordNum.value;
	    if(totalvalue.length <1){
			divgenerateRecordNum.innerHTML='<font class="tips_false">请输入</font>';
			}
}
function generateRecordNumclear(){
	divgenerateRecordNum.innerHTML='<font class="tips_true"></font>';
	}



