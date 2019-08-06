
module.exports = async function(context, commands) {
	
	// Navigate to a URL, but do not measure the URL
	await commands.navigate('https://testCompany.oktapreview.com/login/login.htm');
	await commands.wait.byId('okta-signin-username', 10000);
	
	try {
		// Login with entering user name and password
		await commands.addText.byId('xxx@xxx.com', 'okta-signin-username');
		await commands.addText.byId('test-user-name', 'okta-signin-password');
		await commands.click.byIdAndWait('okta-signin-submit');
		// Wait for Security Answer field on the page loading
		await commands.wait.byId('input67', 10000);
		
		// Login successfully with entering security answer
		await commands.addText.byId('testAnswer', 'input67');
		await commands.click.byXpathAndWait('//*[@id="form60"]/div[2]/input'); //??? cannot click
		await commands.wait.byId('main-content', 20000);
		
		return commands.measure.start('https://dev.testApp.testCompany.net');
		// return commands.measure.stop();
	} catch (e) {
		// We try/catch so we will catch if the the input fields can't be found
		// The error is automatically logged in Browsertime an rethrown here
	}
}