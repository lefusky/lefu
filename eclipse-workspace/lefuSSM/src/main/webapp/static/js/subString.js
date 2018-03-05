jQuery.fn.limit = function() {
	var self = $("span[limit]");
	self.each(function() {
		var objString = $(this).text();
		var objLength = $(this).text().length;
		var num = $(this).attr("limit");

		if (objLength > num) {
			objString = $(this).text(objString.substring(0, num) + "...");
		}
	});
}