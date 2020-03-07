export const getRandomFloat = (min: number, max: number): number =>
  Math.random() * (max - min) + min;

export const getRandomInt = (min: number, max: number): number =>
  Math.floor(Math.random() * (max - min + 1) + min);

export const getRandomBool = () => Math.random() >= 0.5;

export const getRandomString = (length: number): string => {
  let chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz";
  let randomString = "";
  for (let i = 0; i < length; i++) {
    let rnum = Math.floor(Math.random() * chars.length);
    randomString = randomString + chars.substring(rnum, rnum + 1);
  }
  return randomString;
};
