/**
 * 
 */

window.onload = function(){
	load_emp();
	loadDashboardView();
	
}

function load_emp(){
	var xhr = new XMLHttpRequest();
	//xhr.open("GET", "emp", true);
	//alert("hi");
	xhr.onreadystatechange = function() {
		
		if(xhr.readyState == 4){
			
			document.getElementById('emp_info').innerHTML = xhr.responseText;
			document.getElementById('emp_id').addEventListener('click', loadDashboardView, false);
			
			//document.getElementById('navbar').innerHTML = xhr.responseText;
			//document.getElementById('tx').addEventListener('click', loadTxView, false);
			//document.getElementById('dashboard').addEventListener('click', loadDashboardView, false);
		}
		
	}
	
	xhr.open("GET", "emp", true);
	xhr.send();
}

function loadDashboardView()
{
	//alert("hi");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function()
	{
		if (xrh.readState == 4 )
		{
			document.getElementById('dashboard').innerHTML = xhr.responseText;
			
		}
	}
	xhr.open("GET", "info", true);
}

//function showEmp_info()
//{
	//console.log("button clicked");
//}