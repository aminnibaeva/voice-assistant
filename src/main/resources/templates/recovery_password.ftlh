<!DOCTYPE html>
<html lang="ru">
<head>

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Email Confirmation</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="" rel="stylesheet" th:href="@{/css/recovery_password.css}">
</head>
<body style="background-color: #e9ecef;">


<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <br>
  <br>

  <tr>
    <td align="center" bgcolor="#e9ecef">
      <table align="center" border="0" cellpadding="0" cellspacing="0" width="600">
        <tr>
          <td align="center" valign="top" width="600">
            <table border="0" cellpadding="0" cellspacing="0" width="100%"
                   style="max-width: 600px;">
              <tr>
                <td align="left" bgcolor="#ffffff"
                    style="padding: 36px 24px 0; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; border-top: 3px solid #d4dadf;">
                  <h1 style="margin: 0; font-size: 32px; font-weight: 700; letter-spacing: -1px; line-height: 48px;">
                    Резервный пароль.</h1>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>

  <tr>
    <td align="center" bgcolor="#e9ecef">
      <table align="center" border="0" cellpadding="0" cellspacing="0" width="600">
        <tr>
          <td align="center" valign="top" width="600">
            <table border="0" cellpadding="0" cellspacing="0" width="100%"
                   style="max-width: 600px;">


              <tr>
                <td align="left" bgcolor="#ffffff"
                    style="padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px;">
                  <p style="margin: 0;">
                    Вы запросили восстановление пароля. Резервный пароль: ${data.newPassword}
                    <br>
                    После входа в аккаунт с помощью резервного пароля рекомендуется сменить пароль в
                    личном кабинете.</p>
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
