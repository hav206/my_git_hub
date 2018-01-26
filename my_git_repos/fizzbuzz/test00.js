window.onload = function(){
	//document.getElementById("subBtn").addEventListener("click", fizzBuzz,false);

}



function fizzBuzz(){
console.log("Im inside function");
var n = document.getElementById('userInput').value;


	for (var x=0; x <= n; x++){

        if((x%5)==0 && (x%3)==0){
            var liNumber = document.createElement('li');
            liNumber.innerHTML='fizzbuzz';
            document.getElementById('result').appendChild(liNumber);
        }
        else if((x%5)==0){
            var liNumber = document.createElement('li');
            liNumber.innerHTML='buzz';
            document.getElementById('result').appendChild(liNumber);
            
        }
        else if((x%3)==0){
            var liNumber = document.createElement('li');
            liNumber.innerHTML='fizz';
            document.getElementById('result').appendChild(liNumber);
            
        }else{
            var liNumber = document.createElement('li');
            liNumber.innerHTML= x;
            document.getElementById('result').appendChild(liNumber);
        }
    

	}
 }
     