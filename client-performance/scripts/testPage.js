
module.exports = async function(context, commands) {
	
	// Navigate to a URL, but do not measure the URL
	return command.measure.start('https://dev.testApp.testCompany.net');
}