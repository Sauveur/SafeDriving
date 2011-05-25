<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page de test</title>
</head>
<style>
.tbCal {
	position: absolute;
	top: 50;
	left: 20;
	border: 1px solid black
}

.DayName {
	font: 12px Arial;
	text-align: center;
	cursor: default;
}

.BtChangeDate {
	FONT: 12px Arial;
	WIDTH: 8px;
	FONT-WEIGHT: bold;
	cursor: hand;
	text-align: center;
}

.LbChangeDate {
	font: 12px Arial;
	WIDTH: 60px;
	cursor: hand;
	text-align: center;
}

.DayOff {
	BORDER: 1px solid gray;
	cursor: default;
}

.DayOn {
	BORDER: 1px solid black;
	cursor: hand;
	FONT: 12px Arial;
	COLOR: black;
	TEXT-ALIGN: center
}

.DayWorking {
	BACKGROUND: #D9FECE
}

.DayNotWorking {
	BACKGROUND: #EEEEEE
}

.DayOver {
	BACKGROUND: #FFFFCC
}

.DayStart {
	BACKGROUND: #66CCCC
}

.MonthList {
	BORDER: 1px solid black;
	TEXT-ALIGN: center;
	FONT: 12px Arial;
	COLOR: black;
	PADDING: 0px;
	BACKGROUND: #FFFFFF;
	WIDTH: 100px;
	POSITION: absolute;
}

.CellMonthList {
	BORDER: none;
	CURSOR: hand;
	TEXT-ALIGN: center;
	FONT: 12px Arial;
	COLOR: black;
	PADDING: 0px;
}

.CellMonthListOver {
	BACKGROUND: #FF0000
}
</style>
<script>
// date au format "JJ/MM/YYYY" obligatoirement
var sStartDate = ""
var aDayNames = new Array("","Lu", "Ma", "Me", "Je", "Ve", "Sa", "Di")
var aMonthName = new Array("","Janvier","Février","Mars","avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Décembre")
var BaseWeekWork = new Array(0,1,1,1,1,1,0,0) // journée de la semaine , travaillée: (1/0)
var CurrentDay = 0
var CurrentMonth = 0
var CurrentYear = 0
</script>
<body onload="init()">
<table CLASS=tbCal onmouseover="MonthList.style.display='none'">
	<tr>
		<td COLSPAN=7>
		<table WIDTH=100%>
			<tr>
				<td CLASS="BtChangeDate" onclick="ChangeCurrentMonth(-1);"><</td>
				<td CLASS="LbChangeDate" onclick="ShowMonthList()" ID=MonthNAme
					NAME=MonthName></td>
				<td CLASS="BtChangeDate" onclick="ChangeCurrentMonth(1);">></td>
				<td></td>
				<td CLASS="BtChangeDate" onclick="ChangeCurrentYear(-1);"><</td>
				<td CLASS="LbChangeDate" ID=YearValue NAME=YearValue
					STYLE="width: 25px">année</td>
				<td CLASS="BtChangeDate" onclick="ChangeCurrentYear(1);">></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td ID=DayName1 NAME=DayName1 CLASS="DayName"></td>
		<td ID=DayName2 NAME=DayName2 CLASS="DayName"></td>
		<td ID=DayName3 NAME=DayName3 CLASS="DayName"></td>
		<td ID=DayName4 NAME=DayName4 CLASS="DayName"></td>
		<td ID=DayName5 NAME=DayName5 CLASS="DayName"></td>
		<td ID=DayName6 NAME=DayName6 CLASS="DayName"></td>
		<td ID=DayName7 NAME=DayName7 CLASS="DayName"></td>
	</tr>
	<tr>
		<td ID=S1J1 NAME=S1J1></td>
		<td ID=S1J2 NAME=S1J2></td>
		<td ID=S1J3 NAME=S1J3></td>
		<td ID=S1J4 NAME=S1J4></td>
		<td ID=S1J5 NAME=S1J5></td>
		<td ID=S1J6 NAME=S1J6></td>
		<td ID=S1J7 NAME=S1J7></td>
	</tr>
	<tr>
		<td ID=S2J1 NAME=S2J1></td>
		<td ID=S2J2 NAME=S2J2></td>
		<td ID=S2J3 NAME=S2J3></td>
		<td ID=S2J4 NAME=S2J4></td>
		<td ID=S2J5 NAME=S2J5></td>
		<td ID=S2J6 NAME=S2J6></td>
		<td ID=S2J7 NAME=S2J7></td>
	</tr>
	<tr>
		<td ID=S3J1 NAME=S3J1></td>
		<td ID=S3J2 NAME=S3J2></td>
		<td ID=S3J3 NAME=S3J3></td>
		<td ID=S3J4 NAME=S3J4></td>
		<td ID=S3J5 NAME=S3J5></td>
		<td ID=S3J6 NAME=S3J6></td>
		<td ID=S3J7 NAME=S3J7></td>
	</tr>
	<tr>
		<td ID=S4J1 NAME=S4J1></td>
		<td ID=S4J2 NAME=S4J2></td>
		<td ID=S4J3 NAME=S4J3></td>
		<td ID=S4J4 NAME=S4J4></td>
		<td ID=S4J5 NAME=S4J5></td>
		<td ID=S4J6 NAME=S4J6></td>
		<td ID=S4J7 NAME=S4J7></td>
	</tr>
	<tr>
		<td ID=S5J1 NAME=S5J1></td>
		<td ID=S5J2 NAME=S5J2></td>
		<td ID=S5J3 NAME=S5J3></td>
		<td ID=S5J4 NAME=S5J4></td>
		<td ID=S5J5 NAME=S5J5></td>
		<td ID=S5J6 NAME=S5J6></td>
		<td ID=S5J7 NAME=S5J7></td>
	</tr>
	<tr>
		<td ID=S6J1 NAME=S6J1></td>
		<td ID=S6J2 NAME=S6J2></td>
		<td ID=S6J3 NAME=S6J3></td>
		<td ID=S6J4 NAME=S6J4></td>
		<td ID=S6J5 NAME=S6J5></td>
		<td ID=S6J6 NAME=S6J6></td>
		<td ID=S6J7 NAME=S6J7></td>
	</tr>
</table>
<div ID=MonthList CLASS="MonthList" STYLE="display: none;">
<table WIDTH=100%>
	<tr>
		<td ID=M1 NAME=M1 CLASS=CellMonthList
			onmouseover="this.className='CellMonthList CellMonthListOver'"
			onmouseout="this.className='CellMonthList'"></td>
	</tr>
	<tr>
		<td ID=M2 NAME=M2 CLASS=CellMonthList
			onmouseover="this.className='CellMonthList CellMonthListOver'"
			onmouseout="this.className='CellMonthList'"></td>
	</tr>
	<tr>
		<td ID=M3 NAME=M3 CLASS=CellMonthList
			onmouseover="this.className='CellMonthList CellMonthListOver'"
			onmouseout="this.className='CellMonthList'"></td>
	</tr>
	<tr>
		<td ID=M4 NAME=M4 CLASS=CellMonthList
			onmouseover="this.className='CellMonthList CellMonthListOver'"
			onmouseout="this.className='CellMonthList'"></td>
	</tr>
	<tr>
		<td ID=M5 NAME=M5 CLASS=CellMonthList
			onmouseover="this.className='CellMonthList CellMonthListOver'"
			onmouseout="this.className='CellMonthList'"></td>
	</tr>
	<tr>
		<td ID=M6 NAME=M6 CLASS=CellMonthList
			onmouseover="this.className='CellMonthList CellMonthListOver'"
			onmouseout="this.className='CellMonthList'"></td>
	</tr>
	<tr>
		<td ID=M7 NAME=M7 CLASS=CellMonthList
			onmouseover="this.className='CellMonthList CellMonthListOver'"
			onmouseout="this.className='CellMonthList'"></td>
	</tr>
	<tr>
		<td ID=M8 NAME=M8 CLASS=CellMonthList
			onmouseover="this.className='CellMonthList CellMonthListOver'"
			onmouseout="this.className='CellMonthList'"></td>
	</tr>
	<tr>
		<td ID=M9 NAME=M9 CLASS=CellMonthList
			onmouseover="this.className='CellMonthList CellMonthListOver'"
			onmouseout="this.className='CellMonthList'"></td>
	</tr>
	<tr>
		<td ID=M10 NAME=M10 CLASS=CellMonthList
			onmouseover="this.className='CellMonthList CellMonthListOver'"
			onmouseout="this.className='CellMonthList'"></td>
	</tr>
	<tr>
		<td ID=M11 NAME=M11 CLASS=CellMonthList
			onmouseover="this.className='CellMonthList CellMonthListOver'"
			onmouseout="this.className='CellMonthList'"></td>
	</tr>
	<tr>
		<td ID=M12 NAME=M12 CLASS=CellMonthList
			onmouseover="this.className='CellMonthList CellMonthListOver'"
			onmouseout="this.className='CellMonthList'"></td>
	</tr>
</table>
</div>
<script>
var isdoing = false
function ShowMonthList(){
MonthList.top = 0
MonthList.style.display = 'block'
}
// Changement d'année (+1,-1)
function ChangeCurrentYear(value){
if (isdoing == false){
var nb = CurrentYear*1
CurrentYear = nb+value
var str = GetDateString(1,CurrentMonth, CurrentYear)
isdoing = true
WriteDateCells(str)
isdoing = false}
}
// Changement de mois (+1,-1)
function ChangeDate(Type, Value){
if (Type == "m"){CurrentMonth = Value}
if (isdoing == false){
var str = GetDateString(1,CurrentMonth, CurrentYear)
isdoing = true
WriteDateCells(str)
MonthList.style.display = 'none'
isdoing = false}
}
// Changement de mois
function ChangeCurrentMonth(value){
if (isdoing == false){
CurrentMonth = CurrentMonth + value
if(CurrentMonth == 13){CurrentMonth=1; CurrentYear++;}
if(CurrentMonth == 0){CurrentMonth=12; CurrentYear--;}
var str = GetDateString(1,CurrentMonth, CurrentYear)
isdoing = true
WriteDateCells(str)
isdoing = false}
}
function GetDateString(d,m,y){
if (d <= 9){d = "0" + d}
if (m <= 9){m = "0" + m}
return(d + "/" + m + "/" + y)
}
function WriteDayNames(){
for (i=1; i<=7; i++){
var td = document.all("DayName" + i )
td.innerText = aDayNames[i]
}
}
function WriteMonhCells(){
for (i=1; i<=12; i++){
document.all("M" + i ).innerHTML = "<SPAN CLASS=CellMonthList onclick=\"ChangeDate('m'," + i + ")\">" + aMonthName[i] + "</SPAN>"
}
}
// Travaillé/Chomé
function GetDayType(J,M,A){
var cDate = new Date(A,M,J)
var DayNb = cDate.getDay()
if (DayNb == 0) {DayNb = 7}
var Result = BaseWeekWork[DayNb]
return Result
}
function WriteDateCells(StringDate){
var cDay = StringDate.substring(0,2)
var cMonth = StringDate.substring(3,5)-1
var cYear = StringDate.substring(6,10)
CurrentDay = cDay
CurrentMonth = cMonth+1
CurrentYear = cYear
MonthNAme.innerText = aMonthName[cMonth+1]
YearValue.innerText = cYear
var BeginDate = new Date(cYear,cMonth,1)
var MaxDay = 1
// Dernier jour du mois:
for (j=27;j<33;j++){
var cDate = new Date(cYear,cMonth,j)
if (cDate.getDate() == 1){MaxDay = j-1}
}
var EndDate = new Date(cYear,cMonth,MaxDay)
var cWeek = 1
ClearCells()
// Remplissage des cellules:
for (d=1; d<=MaxDay; d++){
var cDate = new Date(cYear ,cMonth, d)
var DayNb = cDate.getDay()
if (DayNb == 0) {DayNb = 7} // J de la semaine de 1 a 7
var Cell = document.all("S" + cWeek + "J" + DayNb)
var OrigClass = ""
// Type de jour: Travaillé/Chomé/Date de départ
if(GetDayType(d,cMonth,cYear)==1)
{OrigClass='DayWorking'}
else
{OrigClass='DayNotWorking'}
if(GetDateString(d,(cMonth+1),cYear) == sStartDate) {OrigClass='DayStart'}
Cell.className = 'DayOn ' + OrigClass
Cell.innerHTML = "<SPAN WIDTH=100% onclick=\"alert('" + GetDateString(d,(cMonth+1),cYear) + "');\" onmouseover=\"S" + cWeek + "J" + DayNb + ".className = 'DayOn DayOver';\" onmouseout=\"S" + cWeek + "J" + DayNb + ".className = 'DayOn " + OrigClass + "';\">" + d + "</SPAN>"
if (DayNb == 7) {cWeek++} // Changement de semaine
}
}
// Effacement de toutes les cellules
function ClearCells(){
for (s=1;s<=6;s++){
for(j=1;j<=7;j++){
document.all("S" + s + "J" + j).innerHTML = ""
document.all("S" + s + "J" + j).className = ""
}
}
}
// Initialisation
function init(){
sStartDate = "05/06/2003"// Date de depart
WriteDayNames() // ecrits les noms de jour
WriteMonhCells()// ecrits les noms de mois
WriteDateCells(sStartDate)// Crée le calendarier
}
</script>
</body>
</html>
