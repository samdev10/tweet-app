export function getCookie(name: string): string | null {
  var cookies = document.cookie.split(";");
  for (var i = 0; i < cookies.length; i++) {
    var cookiePair = cookies[i].split("=");
    if (name === cookiePair[0].trim()) {
      return cookiePair[1];
    }
  }
  return null;
}
