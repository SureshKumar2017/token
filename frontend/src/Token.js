import React, { useState } from 'react';
import { NotificationContainer } from 'react-notifications';
import { MultiSelect } from "react-multi-select-component";
import { NotificationManager } from 'react-notifications';
import axios from 'axios';
import 'react-notifications/lib/notifications.css';
import './tokennotifications.css';
import './Token.css';
import './index.css';

const options = [
	{ label: "0", value: "0" },
	{ label: "1", value: "1" },
	{ label: "2", value: "2" },
	{ label: "3", value: "3" },
	{ label: "4", value: "4" },
	{ label: "5", value: "5" },
	{ label: "6", value: "6" },
	{ label: "7", value: "7" },
	{ label: "8", value: "8" },
	{ label: "9", value: "9" },
  
  ];
  
  function Token() {
	const [token, setToken] = useState([]);
	const [selected, setSelected] = useState([]);
	const [tokenValidStatus, setTokenValidStatus] = useState([]);
	const [tokenValidMessage, setTokenValidMessage] = useState([]);
  	const [errorMessage, setErrorMessage] = React.useState("");

	const getcolor = (tokenValidStatus) => {
		if (tokenValidStatus === 'Success') return 'green';
		if (tokenValidStatus === 'Fail')
			return 'red';
			return '';
	 };
	const handleTokenGeneration = (e) => {
	  e.preventDefault();
		//alert("Inside token generation")
	  if(selected.length>0){
		setErrorMessage("")
		  var inputData = ''
			selected.map(o => 
			inputData = inputData+ o.value +","
			)
			const userData = {
			  inputDigit:inputData
			};
		
			axios.post('http://localhost:8082/token/generate',userData)
			.then(response => {
			  setToken(response.data.token);
			  NotificationManager.success("Token number "+response.data.token+" generated sucessfully");
			})
			.catch(error => {
				console.log(error);
				var errResponseCode = error.code;
				if(errResponseCode==='ERR_NETWORK'){
					NotificationManager.error("Network Error");
				}else{
					NotificationManager.error(error.response.data.errorMessage);
				}
				
			  setTokenValidMessage("")
			  setToken("");
			  console.error(error);
			});
	  }else{
		setTokenValidMessage("")
		setToken("");
		NotificationManager.error('Please choose digits to generate token');
	  }
	}
  
	const handleTokenValidation = (e) => {
	  e.preventDefault();
	  if(token.length>0){
		axios.get('http://localhost:8081/token/validate/'+token)
		.then(response => {
		  NotificationManager.success("Token validated sucessfully");
		  setTokenValidMessage(response.data.message);
		  setTokenValidStatus(response.data.status)
		})
		.catch(error => {
		  setToken("");
		  console.error(error.code);
		  var errResponseCode = error.code;
		  if(errResponseCode==='ERR_NETWORK'){
			NotificationManager.error("Network Error");
		  }else{
			NotificationManager.error(error.response.data.errorMessage);
		  }

		});
	  }else{
		NotificationManager.error("Please generate the token before validate");
		setTokenValidMessage("")
		setToken("");
	  }
	}

	const reset = () => {
		setTokenValidMessage("")
		setToken("")
		setTokenValidStatus("")
		setTokenValidMessage("")
		setErrorMessage("")
		setSelected(options)
	  }
	  
	return (
	  <div style={{ margin: '50px', textalign:"right" }}>
		<NotificationContainer className="notification12"/>
		 {errorMessage && <div className='error'> {errorMessage} </div>}
				<table>
							<tr>
							<td width="60%"><h4> Choose digit to generate token</h4></td>
							<td width="20%"></td>
							<td width="20%" align="right"><MultiSelect 
								options={options}
								value={selected}
								onChange={setSelected}
								labelledBy="Select"/></td>
					 </tr>
			  </table>
  
			<table border="1" >
			  <tr>
				<th>Token Generation</th>
				<th></th>
			  </tr>
				  <tr>
							<td width="30%" align="right"><b> Click the button to generate token</b>  <button onClick={handleTokenGeneration} className="button-18">Generate</button></td>
					  		<td width="30%" align="right"><b>{token}</b></td>
				  </tr>
			</table>
  
			
			<div id="tokenValidation">

				<table border="1">
					<tr>
						<th>Token Validation</th>
						<th></th>
					</tr>
							<tr>
										<td width="30%" align="right"><b> Click the button to validate token</b>  <button onClick={handleTokenValidation} className="button-18">Validate</button></td>
										<td width="30%" align="right" style={{ color: getcolor(tokenValidStatus) }}>
											<b> {tokenValidMessage}</b>
									     </td>
							</tr>
			   	</table>
			 </div>

			 <div id="tokenValidation12">

			 	<table>
					<tr >
						<td> <button onClick={reset} >Reset</button></td>
					</tr>
						
			   	</table>
			 </div>
			
		</div>
	);
  }
  export default Token;
