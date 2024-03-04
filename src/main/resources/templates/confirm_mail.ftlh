<!DOCTYPE html>
<html lang="ru">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Email Confirmation</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<table class="container">
  <tr>
    <td>
      <table>
        <tr>
          <td>
            <table class="container">
              <tr>
                <td class="header">
                  <h1>Здравствуйте, ${data.username}, подтвердите адрес электронной почты.</h1>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>

  <tr>
    <td>
      <table>
        <tr>
          <td>
            <table class="container">
              <tr>
                <td class="content">
                  <p>Скопируйте этот код в ваше приложение, чтобы подтвердить адрес электронной
                    почты. Если вы не создавали аккаунт, пожалуйста, проигнорируйте сообщение.
                    <br>Ваш код верификации: ${data.confirmCode}</p>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</body>
</html>
